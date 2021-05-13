package miniproject.book_management.dto;

import java.sql.Date;

public class RentalDto {
    private Long id;
    private Long memberId;
    private Long bookId;
    private Date expireDate;

    public RentalDto(Long id, Long memberId, Long bookId, Date expireDate) {
        this.id = id;
        this.memberId = memberId;
        this.bookId = bookId;
        this.expireDate = expireDate;
    }

    public RentalDto() {
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

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }
}
