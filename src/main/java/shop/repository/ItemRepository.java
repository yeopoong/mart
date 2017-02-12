package shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shop.domain.item.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
