package com.filipeabessa.paokentin.batch;

import com.filipeabessa.paokentin.batch.dtos.GetBatchDto;
import com.filipeabessa.paokentin.breadtype.BreadTypeEntity;
import com.filipeabessa.paokentin.breadtype.BreadTypeRepository;
import com.filipeabessa.paokentin.common.interfaces.GenericRepository;

import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.filipeabessa.paokentin.common.ConnectionManager.getCurrentConnection;

@Repository
public class BatchRepository {
    private final BreadTypeRepository breadTypeRepository ;
    BatchRepository() {
        this.breadTypeRepository = new BreadTypeRepository();

        String sql = "CREATE TABLE IF NOT EXISTS batch (id BIGINT AUTO_INCREMENT PRIMARY KEY, bread_type_id BIGINT, quantity INT, created_at DATETIME, finish_at DATETIME)";

        try (PreparedStatement preparedStatement = getCurrentConnection().prepareStatement(sql)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public BatchEntity create(BatchEntity batch) {
        String sql = "INSERT INTO batch (bread_type_id, quantity, created_at, finish_at) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = getCurrentConnection().prepareStatement(sql)){

            preparedStatement.setLong(1, batch.getBreadTypeId());
            preparedStatement.setLong(2, batch.getBreadsQuantity());
            preparedStatement.setTimestamp(3, new Timestamp(batch.getCreatedAt().getTime()));
            preparedStatement.setTimestamp(4, new Timestamp(batch.getFinishAt().getTime()));

            preparedStatement.execute();
            return batch;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

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
    public void deleteById(Long id) {
        String sql = "DELETE FROM batch WHERE id = ?";
        try (PreparedStatement preparedStatement = getCurrentConnection().prepareStatement(sql)) {
            preparedStatement.setLong(1, id);

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public BatchEntity update(BatchEntity batch) {
        String sql = "UPDATE batch SET bread_type_id = ?, quantity = ?, created_at = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = getCurrentConnection().prepareStatement(sql)){

            preparedStatement.setLong(1, batch.getBreadTypeId());
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

    public List<GetBatchDto> findAll() {
        String sql = "SELECT * FROM batch b INNER JOIN bread_type bt ON b.bread_type_id = bt.id";
        List<GetBatchDto> batches = new ArrayList<>();

        try (PreparedStatement preparedStatement = getCurrentConnection().prepareStatement(sql)) {
            ResultSet result = preparedStatement.executeQuery();


            while (result.next()) {
                GetBatchDto batch = new GetBatchDto();
                batch.setId(result.getLong("id"));
                batch.setBreadsQuantity(result.getInt("quantity"));
                batch.setCreatedAt(result.getString("created_at"));
                batch.setFinishAt(result.getString("finish_at"));

                Optional<BreadTypeEntity> breadType = breadTypeRepository.findById((result.getLong("bread_type_id")));
                batch.setBreadType(breadType.get());


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

        BreadTypeEntity breadType = breadTypeRepository.findById(batch.getBreadTypeId()).get();
    }

    public boolean existsById(Long id) {
        String sql = "SELECT * FROM batch WHERE id = ?";
        try (PreparedStatement preparedStatement = getCurrentConnection().prepareStatement(sql)) {
            preparedStatement.setLong(1, id);

            ResultSet result = preparedStatement.executeQuery();

            return !result.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
