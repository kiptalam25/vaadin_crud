package com.file.tracker;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Route(value = "home", layout = MainLayout.class)
@PageTitle("Home | File Tracking")
//@Route("")
public class MainView extends VerticalLayout {
    private final FileService fileService;
    private final Grid<FileEntity> grid = new Grid<>(FileEntity.class);

    private final TextField fileNameField = new TextField("File Name");
    private final TextField departmentField = new TextField("Department");


    @Autowired
    public MainView(FileService fileService) {
        this.fileService = fileService;

        Button addButton = new Button("Add File", event -> addFile());
        Button deleteButton = new Button("Delete Selected", event -> deleteSelected());

        grid.setItems(fileService.getAllFiles());
        grid.setColumns("id", "fileName", "department", "timestamp");
        HorizontalLayout formLayout = new HorizontalLayout(fileNameField, departmentField, addButton, deleteButton);
        formLayout.setSpacing(true); // Adds space between components
        formLayout.setPadding(true); // Optional padding


        add(formLayout, addButton, deleteButton, grid);
    }

    private void addFile() {
        String fileName = fileNameField.getValue();
        String department = departmentField.getValue();
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        if (!fileName.isEmpty() && !department.isEmpty()) {
            FileEntity file = new FileEntity(fileName, department, timestamp);
            fileService.saveFile(file);
            grid.setItems(fileService.getAllFiles());
            Notification.show("File added successfully!");
        } else {
            Notification.show("Please fill all fields!");
        }
    }

    private void deleteSelected() {
        FileEntity selected = grid.asSingleSelect().getValue();
        if (selected != null) {
            fileService.deleteFile(selected.getId());
            grid.setItems(fileService.getAllFiles());
            Notification.show("File deleted!");
        } else {
            Notification.show("No file selected!");
        }
    }
}
