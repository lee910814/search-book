package miniproject.book_management.dto;

import java.sql.Date;

public class RentalBookDto {
    private Long id;
    private Long memberId;
    private Long bookId;
    private String bookName;
    private String publisher;
    private String author;
    private Date expireDate;

    public RentalBookDto() {
    }

    public RentalBookDto(Long id, Long memberId, Long bookId, String bookName, String publisher, String author, Date expireDate) {
        this.id = id;
        this.memberId = memberId;
        this.bookId = bookId;
        this.bookName = bookName;
        this.publisher = publisher;
        this.author = author;
        this.expireDate = expireDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }
}
