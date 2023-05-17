package com.example.tppoo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
        import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.util.StringConverter;

import java.net.URL;
        import java.time.DayOfWeek;
        import java.time.LocalDate;
        import java.time.format.DateTimeFormatter;
        import java.util.ResourceBundle;

public class PlannerController implements Initializable {



    @FXML
    private TableColumn<?, ?> fridayLabel;

    @FXML
    private TableColumn<?, ?> sundayLabel;

    @FXML
    private TableColumn<?, ?> saturdayLabel;

    @FXML
    private TableColumn<?, ?> mondayLabel;

    @FXML
    private TableColumn<?, ?> thursdayLabel;

    @FXML
    private TableColumn<?, ?> tuesdayLabel;

    @FXML
    private TableColumn<?, ?> wednesdayLabel;

    @FXML
    private DatePicker dateselector;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LocalDate currentDate = LocalDate.now();

        // Get the current day of the week
        DayOfWeek currentDayOfWeek = currentDate.getDayOfWeek();

        // Calculate the offset to Monday (assuming Monday as the start of the week)
        int offsetToMonday = currentDayOfWeek.getValue() - DayOfWeek.MONDAY.getValue();

        // Calculate the dates for each day of the week
        LocalDate mondayDate = currentDate.minusDays(offsetToMonday);
        LocalDate tuesdayDate = mondayDate.plusDays(1);
        LocalDate wednesdayDate = mondayDate.plusDays(2);
        LocalDate thursdayDate = mondayDate.plusDays(3);
        LocalDate fridayDate = mondayDate.plusDays(4);
        LocalDate saturdayDate = mondayDate.plusDays(5);
        LocalDate sundayDate = mondayDate.plusDays(6);
        // Format the dates as strings
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd MMM");
        String formattedMondayDate = mondayDate.format(dateFormatter);
        String formattedTuesdayDate = tuesdayDate.format(dateFormatter);
        String formattedWednesdayDate = wednesdayDate.format(dateFormatter);
        String formattedThursdayDate = thursdayDate.format(dateFormatter);
        String formattedFridayDate = fridayDate.format(dateFormatter);
        String formattedSaturdayDate = saturdayDate.format(dateFormatter);
        String formattedSundayDate = sundayDate.format(dateFormatter);

        // Set the dates on the day labels
        mondayLabel.setText(formattedMondayDate);
        tuesdayLabel.setText(formattedTuesdayDate);
        wednesdayLabel.setText(formattedWednesdayDate);
        thursdayLabel.setText(formattedThursdayDate);
        fridayLabel.setText(formattedFridayDate);
        saturdayLabel.setText(formattedSaturdayDate);
        sundayLabel.setText(formattedSundayDate);



    }

    @FXML
    void check(ActionEvent event) {
        LocalDate currentDate = dateselector.getConverter().fromString(dateselector.getEditor().getText());
        //LocalDate currentDate = LocalDate.now();

        // Get the current day of the week
        DayOfWeek currentDayOfWeek = currentDate.getDayOfWeek();

        // Calculate the offset to Monday (assuming Monday as the start of the week)
        int offsetToMonday = currentDayOfWeek.getValue() - DayOfWeek.MONDAY.getValue();

        // Calculate the dates for each day of the week
        LocalDate mondayDate = currentDate.minusDays(offsetToMonday);
        LocalDate tuesdayDate = mondayDate.plusDays(1);
        LocalDate wednesdayDate = mondayDate.plusDays(2);
        LocalDate thursdayDate = mondayDate.plusDays(3);
        LocalDate fridayDate = mondayDate.plusDays(4);
        LocalDate saturdayDate = mondayDate.plusDays(5);
        LocalDate sundayDate = mondayDate.plusDays(6);
        // Format the dates as strings
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd MMM");
        String formattedMondayDate = mondayDate.format(dateFormatter);
        String formattedTuesdayDate = tuesdayDate.format(dateFormatter);
        String formattedWednesdayDate = wednesdayDate.format(dateFormatter);
        String formattedThursdayDate = thursdayDate.format(dateFormatter);
        String formattedFridayDate = fridayDate.format(dateFormatter);
        String formattedSaturdayDate = saturdayDate.format(dateFormatter);
        String formattedSundayDate = sundayDate.format(dateFormatter);

        // Set the dates on the day labels
        mondayLabel.setText(formattedMondayDate);
        tuesdayLabel.setText(formattedTuesdayDate);
        wednesdayLabel.setText(formattedWednesdayDate);
        thursdayLabel.setText(formattedThursdayDate);
        fridayLabel.setText(formattedFridayDate);
        saturdayLabel.setText(formattedSaturdayDate);
        sundayLabel.setText(formattedSundayDate);





    }


}
