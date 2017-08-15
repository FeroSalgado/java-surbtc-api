package cl.ferosalgado.surbtc.model;

public class WithdrawalData {
	
    private String target_address;
    private String tx_hash;
    private String type;
    
	public String getTarget_address() {
		return target_address;
	}
	public void setTarget_address(String target_address) {
		this.target_address = target_address;
	}
	public String getTx_hash() {
		return tx_hash;
	}
	public void setTx_hash(String tx_hash) {
		this.tx_hash = tx_hash;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}