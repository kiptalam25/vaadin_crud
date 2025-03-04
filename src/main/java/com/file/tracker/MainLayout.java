package com.file.tracker;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;//
//import com.vaadin.flow.component.siderbar.SidebarNavigation;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.router.PageTitle;

@Route("")
@PageTitle("File Tracking System")
public class MainLayout extends AppLayout {

    public MainLayout() {
        try {
            createHeader();
            createDrawer();
        } catch (Exception e) {
            e.printStackTrace(); // Log any unexpected errors
        }
    }

    private void createHeader() {
        H1 title = new H1("File Tracking System");
        title.getStyle().set("margin", "0").set("padding", "10px");

        Button logoutButton = new Button("Logout", event -> {
            // Logout logic (e.g., clear session)
        });

        DrawerToggle toggle = new DrawerToggle();

        HorizontalLayout header = new HorizontalLayout(toggle, title);
        header.setWidthFull();
        header.setAlignItems(FlexComponent.Alignment.CENTER);
        header.setPadding(true);

        addToNavbar(header);
    }

    private void createDrawer() {
        RouterLink homeLink = new RouterLink("Home", MainView.class);
        RouterLink reportsLink = new RouterLink("Reports", ReportView.class);
        RouterLink settingsLink = new RouterLink("Settings", SettingsView.class);

        VerticalLayout menuLayout = new VerticalLayout(homeLink, reportsLink, settingsLink);
        menuLayout.setPadding(true);
        menuLayout.setSpacing(true);

        addToDrawer(menuLayout);
    }
}


