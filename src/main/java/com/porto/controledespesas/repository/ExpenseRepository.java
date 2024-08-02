package com.porto.controledespesas.repository;

import com.porto.controledespesas.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
