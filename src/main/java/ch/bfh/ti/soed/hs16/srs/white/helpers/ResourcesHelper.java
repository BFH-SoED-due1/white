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
        path = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
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
