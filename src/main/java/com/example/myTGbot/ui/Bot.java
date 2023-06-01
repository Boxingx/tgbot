package com.example.myTGbot.ui;

import com.example.myTGbot.config.PropertyProvider;
import com.example.myTGbot.controller.BuyerController;
import com.example.myTGbot.controller.ItemController;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Slf4j
public class Bot extends TelegramLongPollingBot {
    @Autowired
    private PropertyProvider propertyProvider;
    @Autowired
    private BuyerController buyerController;

    @Autowired
    private ItemController itemController;

    public Bot (PropertyProvider propertyProvider, BuyerController buyerController, ItemController itemController) {
        this.propertyProvider = propertyProvider;
        this.buyerController = buyerController;
        this.itemController = itemController;
    }

    @Override
    public void onUpdateReceived(Update update) { //при команде старт приветсвие + имя пользователя + часовой пояс пользователя
        System.out.println(update);
        if (update.hasMessage() && update.getMessage().hasText()) {
            String text = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();
            String firstName = update.getMessage().getChat().getFirstName();



            switch (text) {
                case "/start" :
                    sendMessage(chatId, "Привет " + firstName + " " + new Date(System.currentTimeMillis()));
                    buyerController.registration(
                            chatId,
                            firstName,
                            update.getMessage().getChat().getLastName(),
                            new ArrayList<>(),
                            null);
                    break;
                case "/get" :
                    itemController.get(1l);
                    break;

            }
        }
    }

    private InlineKeyboardMarkup getKeyboard() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsButtons = new ArrayList<>();
        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton firstButton = new InlineKeyboardButton();
        firstButton.setText("yes");
        firstButton.setCallbackData("YES");
        InlineKeyboardButton secondButton = new InlineKeyboardButton();
        secondButton.setText("no");
        secondButton.setCallbackData("NO");
        row1.add(firstButton);
        row1.add(secondButton);
        rowsButtons.add(row1);
        inlineKeyboardMarkup.setKeyboard(rowsButtons);
        return inlineKeyboardMarkup;
    }

    private void sendMessage(Long chatId, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);
        sendMessage.setReplyMarkup(getKeyboard());
        try {
            execute(sendMessage);
            log.info("Сообщение отправлено " + chatId + " " + new Timestamp(System.currentTimeMillis()));
        } catch (TelegramApiException e) {
            log.error("Ошибка отправки сообщения " + e.getMessage());
        }
    }

    @Override
    public String getBotUsername() {
        return propertyProvider.getBotName();
    }

    @Override
    public String getBotToken() {
        return propertyProvider.getBotToken();
    }
}
