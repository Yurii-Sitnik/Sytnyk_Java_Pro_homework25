package org.example.homework25;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import static org.example.homework25.DataBaseConnection.closeConnection;

public class LessonDao {


    public LessonDao() throws SQLException {
    }

    public void addLesson(Lesson lesson) throws SQLException {

        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement("insert into Lesson( name, updateAt, homework_id) values (?,?,?)");
        ps.setString(1, lesson.getName());
        ps.setDate(2, lesson.getUpdateAt());
        ps.setInt(3, lesson.getHomework_id());

        ps.executeUpdate();
        closeConnection(connection);
    }

    public Lesson getLessonById(int id) throws SQLException {

        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement("select * from Lesson where id=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        closeConnection(connection);
        return new Lesson(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getInt(4));
    }

    public List<Lesson> getAllLessons() throws SQLException {
        List<Lesson> arrayListLessons = new ArrayList<>();

        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement("select * from Lesson");
        ResultSet rs = ps.executeQuery();
        while (rs.next())
            arrayListLessons.add(new Lesson(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getInt(4)));
        closeConnection(connection);
        return arrayListLessons;
    }

    public void deleteLesson(Lesson lesson) throws SQLException {

        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement("delete from lesson where id = " + Lesson.getId());
        ps.executeUpdate();
        closeConnection(connection);
    }
}
