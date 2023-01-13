package acme;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface BooksRepository extends PagingAndSortingRepository<Book, Long> {
}
