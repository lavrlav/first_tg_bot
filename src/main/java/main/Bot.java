package main;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "overone_student_music_bot";
    }

    @Override
    public String getBotToken() {
        return "5818636397:AAFcTHSsUZdQ18vlVAt9baqom1BlYps-_3g";
    }

    //Beatles - Anytime at all CQACAgIAAxkBAAMXY3oFI4HlxCdamvycB1oPzCS4aMcAAgscAAIm_NBLEVav0eViE0ArBA
    //Би-2 - Молитва CQACAgIAAxkBAAMZY3oFf9LOGaOR8ia9cseXPUWepWAAAg4cAAIm_NBLEJyK1pCNERkrBA
    //Three Days Grace - Break CQACAgIAAxkBAAMbY3oFzVgRwyiQbj_kQGVV-tHk_MkAAhAcAAIm_NBLaTowAAEXg-ypKwQ
    //Beatles - A day in the life CQACAgIAAxkBAAMdY3oGKHXUYwPLDDksOBqcL8Sa_nMAAhIcAAIm_NBL8-L0cAXt5t8rBA
    // Би-2 - Полковнику никто не пишет CQACAgIAAxkBAAMfY3oGk7Ouj1VzZTLKjjGsGkeNefEAAhMcAAIm_NBLO-ZWtHOyUXArBA


    @Override
    public void onUpdateReceived(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());
        /*SendAudio sendAudio = new SendAudio();
        sendAudio.setChatId(update.getMessage().getChatId().toString());
        sendAudio.setAudio(new InputFile("CQACAgIAAxkBAAMXY3oFI4HlxCdamvycB1oPzCS4aMcAAgscAAIm_NBLEVav0eViE0ArBA"));
        sendAudio.setCaption("The best song ever");

        try {
            execute(sendAudio);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }*/
        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add(new KeyboardButton( "Би-2 - Полковнику никто не пишет"));
        keyboardRow1.add(new KeyboardButton("Beatles - Anytime at all"));

        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow2.add(new KeyboardButton("Three Day Grace - Break"));
        keyboardRow2.add(new KeyboardButton("Beatles - A day in the life" ));
        keyboardRow2.add(new KeyboardButton("Би-2 - Молитва"));

        List<KeyboardRow> list = new ArrayList<>();
        list.add(keyboardRow1);
        list.add(keyboardRow2);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(list);
        sendMessage.setText(update.getMessage().getText());
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        SendAudio sendAudio = new SendAudio();
        sendAudio.setChatId(update.getMessage().getChatId().toString());
        InputFile inputFile = new InputFile();

        switch (update.getMessage().getText()) {
            case "Би-2 - Полковнику никто не пишет":
                inputFile.setMedia("CQACAgIAAxkBAAMfY3oGk7Ouj1VzZTLKjjGsGkeNefEAAhMcAAIm_NBLO-ZWtHOyUXArBA");
                break;
            case "Beatles - Anytime at all":
                inputFile.setMedia("CQACAgIAAxkBAAMXY3oFI4HlxCdamvycB1oPzCS4aMcAAgscAAIm_NBLEVav0eViE0ArBA");
                break;
            case "Three Day Grace - Break":
                inputFile.setMedia("CQACAgIAAxkBAAMbY3oFzVgRwyiQbj_kQGVV-tHk_MkAAhAcAAIm_NBLaTowAAEXg-ypKwQ");
                break;
            case "Beatles - A day in the life":
                inputFile.setMedia("CQACAgIAAxkBAAMdY3oGKHXUYwPLDDksOBqcL8Sa_nMAAhIcAAIm_NBL8-L0cAXt5t8rBA");
                break;
            case "Би-2 - Молитва":
                inputFile.setMedia("CQACAgIAAxkBAAMZY3oFf9LOGaOR8ia9cseXPUWepWAAAg4cAAIm_NBLEJyK1pCNERkrBA");
                break;


        }
        sendAudio.setAudio(inputFile);
        try {
            execute(sendAudio);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }



    }
}
