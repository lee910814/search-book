package miniproject.book_management.dto;

public class RentalDto {
    private Long id;
    private Long memberId;
    private Long bookId;
    private int termDay;
    private int overdueDay;

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

    public int getTermDay() {
        return termDay;
    }

    public void setTermDay(int termDay) {
        this.termDay = termDay;
    }

    public int getOverdueDay() {
        return overdueDay;
    }

    public void setOverdueDay(int overdueDay) {
        this.overdueDay = overdueDay;
    }

    public RentalDto() {
    }

    public RentalDto(Long memberId, Long bookId, int termDay, int overdueDay) {
        this.memberId = memberId;
        this.bookId = bookId;
        this.termDay = termDay;
        this.overdueDay = overdueDay;
    }
}
