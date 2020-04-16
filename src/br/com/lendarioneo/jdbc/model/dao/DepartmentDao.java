package br.com.lendarioneo.jdbc.model.dao;

import br.com.lendarioneo.jdbc.model.entities.Department;

import java.util.List;

public interface DepartmentDao {
    void insert(Department department);

    void update(Department department);

    Department findById(int index);

    List<Department> findAll();

    void deleteById(int index);
}
