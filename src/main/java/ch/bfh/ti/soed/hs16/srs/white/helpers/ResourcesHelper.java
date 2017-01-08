/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.helpers;

import com.vaadin.server.VaadinService;

/**
 * Created by arauzca on 18.12.16.
 */
public class ResourcesHelper {
    private static ResourcesHelper uniqueResourcesHelper;
    private String path;

    private ResourcesHelper() {
        final String PROJECT_NAME = "white";

        if (VaadinService.getCurrent() != null)
            path = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
        else {
            path = getClass().getClassLoader().getResource(".").getPath();
            String[] pathSplit = path.split("/");
            StringBuilder pathBuilder = new StringBuilder("/");

            for (String s:pathSplit) {
                if (s.equals(PROJECT_NAME)) {
                    pathBuilder.append(s).append("/src/main/webapp");
                    break;
                }

                if (!s.isEmpty()) pathBuilder.append(s).append("/");
            }

            path = pathBuilder.toString();
        }
    }

    public String getPath() {
        return path;
    }

    public static ResourcesHelper getInstance() {
        if (uniqueResourcesHelper == null) {
            uniqueResourcesHelper = new ResourcesHelper();
        }

        return uniqueResourcesHelper;
    }
}
