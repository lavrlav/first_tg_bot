package main;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

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
        SendAudio sendAudio = new SendAudio();
        for (int i = 0; i < 3; i++) {


            sendAudio.setChatId(update.getMessage().getChatId().toString(i));
            sendAudio.setAudio(new InputFile("CQACAgIAAxkBAAMXY3oFI4HlxCdamvycB1oPzCS4aMcAAgscAAIm_NBLEVav0eViE0ArBA"));
            sendAudio.setCaption("The best song ever");
        }
        try {
            execute(sendAudio);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }
}
