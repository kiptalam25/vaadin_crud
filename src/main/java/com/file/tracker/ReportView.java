package com.file.tracker;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "reports", layout = MainLayout.class)
@PageTitle("Reports | Reports")
public class ReportView extends VerticalLayout {
    public ReportView() {
        add(new H1("Welcome to the File Tracking System Reports!"));
    }
}
