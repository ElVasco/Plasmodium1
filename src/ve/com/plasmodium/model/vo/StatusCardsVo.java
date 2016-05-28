package ve.com.plasmodium.model.vo;

public class StatusCardsVo {
	
	private short status;
	private int totalCards;
	
	public StatusCardsVo (short status, int totalCards) {
		this.setStatus(status);
		this.setTotalCards(totalCards);
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public int getTotalCards() {
		return totalCards;
	}

	public void setTotalCards(int totalCards) {
		this.totalCards = totalCards;
	}

}
