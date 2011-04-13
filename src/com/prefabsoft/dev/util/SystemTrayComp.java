package com.prefabsoft.dev.util;


import java.awt.AWTException;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;

public class SystemTrayComp {
	
	public static void main(String[] args) {
		new SystemTrayComp("logo.jpg");

	}

	private final PopupMenu popup = new PopupMenu();
	private TrayIcon trayIcon;
	private final SystemTray tray = SystemTray.getSystemTray();

	public SystemTrayComp(String iconUrl) {
		if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }
		trayIcon = new TrayIcon(createImage(iconUrl==null?iconUrl:"logo.jpg", "tray icon"));
		
		trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("prefabSOFT Coder Tool");
        
        createMenu();
        trayIcon.setPopupMenu(popup);
        
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
            return;
        }
        
	}
	
	private void createMenu() {
		// Create a popup menu components
        MenuItem aboutItem = new MenuItem("About");
        MenuItem openMenu = new Menu("Open");
        MenuItem exitItem = new MenuItem("Exit");
        
        //Add components to popup menu
        popup.add(aboutItem);
        popup.add(openMenu);
        popup.addSeparator();
        popup.add(exitItem);
        
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tray.remove(trayIcon);
                System.exit(0);
            }
        });
	}

	//Obtain the image URL
    protected static Image createImage(String path, String description) {
        URL imageURL = SystemTrayComp.class.getResource(path);
        
        if (imageURL == null) {
            System.err.println("Resource not found: " + path);
            return null;
        } else {
            return (new ImageIcon(imageURL, description)).getImage();
        }
    }
	
}
