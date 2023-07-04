package com.filipeabessa.paokentin.breadtype;

import com.filipeabessa.paokentin.common.interfaces.GenericRepository;
import org.springframework.stereotype.Repository;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.filipeabessa.paokentin.common.ConnectionManager.getCurrentConnection;

@Repository
public class BreadTypeRepository implements GenericRepository<BreadTypeEntity, Long> {

    BreadTypeRepository() {
        String sql = "CREATE TABLE IF NOT EXISTS bread_type (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(255) NOT NULL," +
                "description VARCHAR(255) NOT NULL," +
                "price DECIMAL(10,2) NOT NULL," +
                "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                "updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP" +
                ");";
        try (PreparedStatement preparedStatement = getCurrentConnection().prepareStatement(sql)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public BreadTypeEntity create(BreadTypeEntity breadType) {
        String sql = "INSERT INTO bread_type (name, description, price) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = getCurrentConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, breadType.getName());
            preparedStatement.setString(2, breadType.getDescription());
            preparedStatement.setDouble(3, breadType.getPricePerUnit());
            preparedStatement.execute();
            return breadType;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return breadType;
    }

    @Override
    public BreadTypeEntity update(BreadTypeEntity breadType) {
        String sql = "UPDATE bread_type SET name = ?, description = ?, price = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = getCurrentConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, breadType.getName());
            preparedStatement.setString(2, breadType.getDescription());
            preparedStatement.setDouble(3, breadType.getPricePerUnit());
            preparedStatement.setLong(4, breadType.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return breadType;
    }

    @Override
    public void deleteById(Long breadTypeId) {
        String sql = "DELETE FROM bread_type WHERE id = ?";

        try (PreparedStatement preparedStatement = getCurrentConnection().prepareStatement(sql)) {
            preparedStatement.setLong(1, breadTypeId);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<BreadTypeEntity> findAll() {
        String sql = "SELECT * FROM bread_type";
        List<BreadTypeEntity> breadTypes = new ArrayList<>();

        try (PreparedStatement preparedStatement = getCurrentConnection().prepareStatement(sql)) {
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                BreadTypeEntity breadType = new BreadTypeEntity();
                breadType.setId(result.getLong("id"));
                breadType.setName(result.getString("name"));
                breadType.setDescription(result.getString("description"));
                breadType.setPricePerUnit(result.getDouble("price"));
                breadTypes.add(breadType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return breadTypes;
    }

    @Override
    public Optional<BreadTypeEntity> findById(Long breadTypeId) {
        String sql = "SELECT * FROM bread_type WHERE id = ?";
        try (PreparedStatement preparedStatement = getCurrentConnection().prepareStatement(sql)) {
            preparedStatement.setLong(1, breadTypeId);

            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                BreadTypeEntity breadType = new BreadTypeEntity();
                breadType.setId(result.getLong("id"));
                breadType.setName(result.getString("name"));
                breadType.setDescription(result.getString("description"));
                breadType.setPricePerUnit(result.getDouble("price"));
                return Optional.of(breadType);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public boolean existsById(long id) {
        String sql = "SELECT * FROM bread_type WHERE id = ?";
        try (PreparedStatement preparedStatement = getCurrentConnection().prepareStatement(sql)) {
            preparedStatement.setLong(1, id);

            ResultSet result = preparedStatement.executeQuery();

            return result.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
