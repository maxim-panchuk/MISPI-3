package com.panchuk.shooter.business.dao;


    public void add(Point point) {
        try {
            begin();
            em.persist(point);
            em.flush();
            end();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public List<Point> getAll () {
        try {
            begin();
            @SuppressWarnings("unchecked")
            List<Point> resultList = em.createQuery("SELECT point FROM Point point").getResultList();
            end();
            return resultList;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public void clear() {
        try {
            begin();
            Query query = em.createQuery("delete FROM Point");
            query.executeUpdate();
            end();
        } catch (Exception unexpected) {
            unexpected.printStackTrace();
        }
    }

    private void begin() {
        em.getTransaction().begin();
    }

    private void end() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().commit();
        } else {
            throw new RuntimeException("Inactive transaction");
        }
    }
}
