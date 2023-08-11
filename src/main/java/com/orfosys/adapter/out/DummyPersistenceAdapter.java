package com.orfosys.adapter.out;

import com.orfosys.application.out.FindDummyById;
import com.orfosys.common.annotation.PersistenceAdapter;
import com.orfosys.common.exception.DummyException;
import com.orfosys.domain.model.Dummy;

import lombok.AllArgsConstructor;

@PersistenceAdapter
@AllArgsConstructor
public class DummyPersistenceAdapter implements FindDummyById {
    
    private final DummyEntityRepository dummyEntityRepository;

    @Override
    public Dummy findById(int id) {
        return dummyEntityRepository
                .findById(id)
                .map(DummyMapper::entityToDomain)
                .orElseThrow(DummyException::new);
    }
}
