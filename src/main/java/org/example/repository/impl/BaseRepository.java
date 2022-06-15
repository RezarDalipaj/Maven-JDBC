package org.example.repository.impl;

import org.example.mapper.Mapper;
import org.example.repository.Repository;

public abstract class BaseRepository<ENTITY, ID> implements Repository<ENTITY, ID> {

    private final Mapper<ENTITY> mapper;

    public BaseRepository(Mapper<ENTITY> mapper) {
        this.mapper = mapper;
    }

    protected Mapper<ENTITY> getMapper() {
        return mapper;
    }

}
