package app.controller;

import common.service.EntityService;

import javax.persistence.EntityManager;

/**
 * コントローラクラスの基底クラスです。
 *
 * @author Hiroshi HASEGAWA
 */
public class ControllerBase {

    /**
     * エンティティマネージャを取得します。
     * @return エンティティマネージャ
     */
    public EntityManager getEntityManager() {
        return EntityService.getInstance().getEntityManager();
    }
}
