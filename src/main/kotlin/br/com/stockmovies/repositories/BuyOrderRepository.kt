package br.com.stockmovies.repositories

import br.com.stockmovies.models.BuyOrder
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BuyOrderRepository : JpaRepository<BuyOrder, Long>