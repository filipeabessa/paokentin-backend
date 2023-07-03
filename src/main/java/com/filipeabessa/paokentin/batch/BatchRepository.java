package com.filipeabessa.paokentin.batch;

import com.filipeabessa.paokentin.common.ConnectionManager;
import com.filipeabessa.paokentin.common.interfaces.GenericRepository;

import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class BatchRepository implements GenericRepository<BatchEntity, Long> {
    BatchRepository() {
        try {
            ConnectionManager.getCurrentConnection().createStatement().execute("CREATE TABLE IF NOT EXISTS batch (id BIGINT PRIMARY KEY, bread_type_id BIGINT, quantity INT, created_at DATE)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public BatchEntity create(BatchEntity batch) {
        try{
            String sql = "INSERT INTO batch (id, bread_type_id, quantity, created_at) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = ConnectionManager.getCurrentConnection().prepareStatement(sql);

            preparedStatement.setLong(1, batch.getId());
            preparedStatement.setLong(2, batch.getBreadType().getId());
            preparedStatement.setLong(3, batch.getBreadsQuantity());
            preparedStatement.setDate(4, new Date(batch.getCreatedAt().getTime()));

            preparedStatement.execute();
            return batch;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Optional<BatchEntity> findById(Long id) {
        return Optional.empty();
    }
    @Override
    public void deleteById(Long id) {

    }

    @Override
    public BatchEntity update(BatchEntity entity) {
        return null;
    }

    @Override
    public List<BatchEntity> findAll() {
        return null;
    }
}
