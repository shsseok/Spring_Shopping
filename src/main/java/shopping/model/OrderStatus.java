package shopping.model;
/**
 * TODO 부가기능이 들어갈 수 있음 EX) 배송중 등등
 * @author order 상태
 *
 */
public enum OrderStatus {
    CANCEL("CANCEL"),
    COMPLETE("COMPLETE");

    private final String status;

    OrderStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}

