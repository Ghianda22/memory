package com.memory.backend.invitations.emails;

import com.memory.backend.exceptions.InvalidEmailException;
import com.memory.backend.invitations.emails.data.EmailRequestBean;
import com.memory.backend.invitations.emails.data.EmailRequestBeanBuilder;
import com.memory.backend.invitations.emails.data.EmailServiceBean;
import com.memory.backend.invitations.emails.services.EmailService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmailDelegateTest {
    @Spy @InjectMocks
    private EmailDelegate emailDelegate;
    @Mock
    private EmailService emailService;

    @CsvSource(value = {
            "alessio@gmail.com,false",
            "a@b.it,false",
            "a#b.it,true",
            "alessio@gmail,true",
            "alessio@gmail.goog,false",
    })
    @ParameterizedTest
    void givenParameters_shouldCheckAddressValidity(String email, Boolean expected) {
        // given

        // when
        Boolean result = emailDelegate.isAddressInvalid(email);

        // then
        assertEquals(expected, result);
    }

    @Test
    void givenEmptyEmailList_onHandleEmails_shouldDoNothing() throws InvalidEmailException {
        // given
        EmailRequestBean emailRequestBean = new EmailRequestBeanBuilder()
                .setEmailList(Collections.emptyList())
                .createEmailRequestBean();

        // when
        emailDelegate.handleEmails(emailRequestBean);

        // then
        verify(emailDelegate, never()).isAddressInvalid(any());
        verify(emailService, never()).sendEmailInvitation(any());
    }

    @Test
    void givenEmailListWithInvalidElement_onHandleEmails_shouldThrowException() {
        // given
        String email = "abcde";
        EmailRequestBean emailRequestBean = new EmailRequestBeanBuilder()
                .setEmailList(Collections.singletonList(email))
                .createEmailRequestBean();

        doReturn(true).when(emailDelegate).isAddressInvalid(any());

        // when
        Executable callable = () -> emailDelegate.handleEmails(emailRequestBean);

        // then
        assertThrows(InvalidEmailException.class, callable);
        verify(emailDelegate, times(1)).isAddressInvalid(email);
    }

    @Test
    void givenEmailList_onHandleEmails_shouldSendEmailInvitation() throws InvalidEmailException {
        // given
        String email = "abcde";
        int numberOfEmails = 20;
        List<String> emails = Stream.generate(() -> "abcde")
                .limit(numberOfEmails)
                .toList();

        EmailRequestBean emailRequestBean = new EmailRequestBeanBuilder()
                .setEmailList(emails)
                .setGameId("mygameid")
                .setGameName("mygamename")
                .createEmailRequestBean();

        doReturn(false).when(emailDelegate).isAddressInvalid(any());
        doNothing().when(emailService).sendEmailInvitation(any());
//        when(emailService.sendEmailInvitation(any())).thenReturn("");

        // when
        emailDelegate.handleEmails(emailRequestBean);

        // then
        verify(emailDelegate, times(numberOfEmails)).isAddressInvalid(eq(email));

        ArgumentCaptor<EmailServiceBean> emailServiceBeanArgumentCaptor = ArgumentCaptor.forClass(EmailServiceBean.class);
        verify(emailService, times(numberOfEmails)).sendEmailInvitation(emailServiceBeanArgumentCaptor.capture());
        assertEquals(email, emailServiceBeanArgumentCaptor.getValue().getEmailAddress());
        assertEquals(emailRequestBean.getGameName(), emailServiceBeanArgumentCaptor.getValue().getGameName());
        assertEquals(emailRequestBean.getGameId(), emailServiceBeanArgumentCaptor.getValue().getGameId());
    }
}