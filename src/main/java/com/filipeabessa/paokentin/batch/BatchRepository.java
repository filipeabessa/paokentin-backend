package com.filipeabessa.paokentin.batch;

import com.filipeabessa.paokentin.breadtype.BreadTypeEntity;
import com.filipeabessa.paokentin.common.interfaces.GenericRepository;

import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.filipeabessa.paokentin.common.ConnectionManager.getCurrentConnection;

@Repository
public class BatchRepository implements GenericRepository<BatchEntity, Long> {
    BatchRepository() {
        String sql = "CREATE TABLE IF NOT EXISTS batch (id BIGINT PRIMARY KEY, bread_type_id BIGINT, quantity INT, created_at DATE)";

        try (PreparedStatement preparedStatement = getCurrentConnection().prepareStatement(sql)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public BatchEntity create(BatchEntity batch) {
        String sql = "INSERT INTO batch (id, bread_type_id, quantity, created_at) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = getCurrentConnection().prepareStatement(sql)){

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
        String sql = "SELECT * FROM batch b INNER JOIN bread_type bt ON b.bread_type_id = bt.id WHERE b.id = ?";

        try (PreparedStatement preparedStatement = getCurrentConnection().prepareStatement(sql)) {

            preparedStatement.setLong(1, id);

            ResultSet result = preparedStatement.executeQuery();
            BatchEntity batch = null;

            if (result.next()) {
                batch = new BatchEntity();
                batch.setId(id);
                prepareBatch(result, batch);
            }
            return Optional.ofNullable(batch);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM batch WHERE id = ?";
        try (PreparedStatement preparedStatement = getCurrentConnection().prepareStatement(sql)) {
            preparedStatement.setLong(1, id);

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public BatchEntity update(BatchEntity batch) {
        String sql = "UPDATE batch SET bread_type_id = ?, quantity = ?, created_at = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = getCurrentConnection().prepareStatement(sql)){

            preparedStatement.setLong(1, batch.getBreadType().getId());
            preparedStatement.setInt(2, batch.getBreadsQuantity());
            preparedStatement.setDate(3, new Date(batch.getCreatedAt().getTime()));
            preparedStatement.setLong(4, batch.getId());

            preparedStatement.execute();

            return batch;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<BatchEntity> findAll() {
        String sql = "SELECT * FROM batch b INNER JOIN bread_type bt ON b.bread_type_id = bt.id";
        List<BatchEntity> batches = new ArrayList<>();

        try (PreparedStatement preparedStatement = getCurrentConnection().prepareStatement(sql)) {
            ResultSet result = preparedStatement.executeQuery();


            while (result.next()) {
                BatchEntity batch = new BatchEntity();
                batch.setId(result.getLong("id"));
                prepareBatch(result, batch);

                batches.add(batch);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return batches;
    }

    private void prepareBatch(ResultSet result, BatchEntity batch) throws SQLException {
        batch.setBreadsQuantity(result.getInt("quantity"));
        batch.setCreatedAt(result.getDate("created_at"));

        BreadTypeEntity breadType = new BreadTypeEntity();
        breadType.setId(result.getLong("bread_type_id"));
        breadType.setName(result.getString("name"));
        breadType.setPricePerUnit(result.getDouble("price_per_unit"));
        batch.setBreadType(breadType);
    }
}
