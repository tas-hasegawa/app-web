package app.controller;

import common.service.EntityService;

import javax.persistence.EntityManager;

public class ControllerBase {

    public EntityManager getEntityManager() {
        return EntityService.getInstance().getEntityManager();
    }
}
