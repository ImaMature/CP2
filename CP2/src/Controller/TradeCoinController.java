package Controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import DAO.CoinDAO;
import DAO.MemberDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class TradeCoinController implements Initializable {

	ArrayList<String> CoinNameArray;
	String[] CoinNameIn;
	String holdingCoinList;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		NowCoinPricetxt.setText(Integer.toString(CoinDAO.getDAO().outPrice(TradeController.getStringCoinName)));
	}

	@FXML
	private Button Buybtn;

	@FXML
	private TextField NowCoinPricetxt;

	@FXML
	private Button Sellbtn;

	@FXML
	private Label BuyAndSellMessageLabel;

	@FXML
	void BuybtnAction(ActionEvent event) {
		int memberMoney = MemberDAO.getMemberDAO().getMemberNO(LoginController.getLoginController().getloginid());
		int buyCoin = MemberDAO.getMemberDAO().getMemberMoney(memberMoney);
		int leftMoney = Integer.parseInt(NowCoinPricetxt.getText());
		if (leftMoney < buyCoin) {
			boolean updatemoney = MemberDAO.getMemberDAO().updateMemberMoney(memberMoney, (buyCoin - leftMoney));
			if (updatemoney) {
				// DB에서 코인Strnig 가져오기
				holdingCoinList = MemberDAO.getMemberDAO().getMemberHoldingCoin(
						MemberDAO.getMemberDAO().getMemberNO(LoginController.getLoginController().getloginid()));
				System.out.println("============================================ : " + holdingCoinList);
				// 가져온 값 아웃풋
				if (holdingCoinList != null) {
					try {
						String path = "C:\\Users\\504\\git\\CP2\\CP2\\src\\text/holdingCoin.txt";
						FileOutputStream fileOutputStream = new FileOutputStream(path);
						int coinNo = CoinDAO.getDAO().getCoinNo(TradeController.getStringCoinName);
						String coinName = holdingCoinList + CoinDAO.getDAO().getCoinName(coinNo) + ",";
						fileOutputStream.write(coinName.getBytes());
						MemberDAO.getMemberDAO().updateMemberHoldingCoin(coinName, MemberDAO.getMemberDAO()
								.getMemberNO(LoginController.getLoginController().getloginid()));

						FileInputStream fileinputStream = new FileInputStream(path);

						byte[] bytes = new byte[100];
						fileinputStream.read(bytes);
						String str = new String(bytes);
						CoinNameArray = new ArrayList<>();
//                  CoinNameIn = str;
						for (int i = 0; i < CoinNameArray.size() - 1; i++) {
							CoinNameArray.add(str);
						}
						MemberDAO.getMemberDAO().updateMemberHoldingCoin(CoinNameArray.get(0), MemberDAO.getMemberDAO()
								.getMemberNO(LoginController.getLoginController().getloginid()));
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				} else {
					try {
						String path = "C:\\Users\\504\\git\\CP2\\CP2\\src\\text/holdingCoin.txt";
						FileOutputStream fileOutputStream = new FileOutputStream(path);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				// 구매한 코인 뒤에 추가
				// 인풋
				// 인풋값 디비로

				BuyAndSellMessageLabel.setText("구매완료");
			}
		} else if (leftMoney == buyCoin) {
			boolean updatemoney = MemberDAO.getMemberDAO().updateMemberMoney(memberMoney, (buyCoin - leftMoney));
			if (updatemoney) {
				BuyAndSellMessageLabel.setText("구매완료");
//             HoldingCoinFileUpload();
			}
		} else {
			BuyAndSellMessageLabel.setText("구매실패 : 잔액부족");
		}
	}
//
	@FXML
	void SellbtnAction(ActionEvent event) {
		holdingCoinList = MemberDAO.getMemberDAO().getMemberHoldingCoin(
				MemberDAO.getMemberDAO().getMemberNO(LoginController.getLoginController().getloginid()));
		CoinNameIn = holdingCoinList.split(",");
		ArrayList<String> hcl = new ArrayList<>();

		for (int i = 0; i < CoinNameIn.length; i++) {
			hcl.add(CoinNameIn[i]);
		}
		for (int i = 0; i < CoinNameIn.length; i++) {
			System.out.println(hcl.toString());
			boolean returnf = hcl.get(i).equals(TradeController.getStringCoinName.trim());
			System.out.println("returnf : " + returnf);
			if (returnf) {

				// 있으면
				System.out.println("hcl.get(0) : " + hcl.get(0));
				System.out.println(hcl.remove(i));
				break;
			}
		}
		try {
			String coinName = "";
			for (int i = 0; i < hcl.size(); i++) {

				String path = "C:\\Users\\504\\git\\CP2\\CP2\\src\\text/holdingCoin.txt";
				FileOutputStream fileOutputStream = new FileOutputStream(path);
				// int coinNo = CoinDAO.getDAO().getCoinNo(TradeController.getStringCoinName);

				coinName = coinName + hcl.get(i) + ",";

				fileOutputStream.write(coinName.getBytes());
				MemberDAO.getMemberDAO().updateMemberHoldingCoin(coinName,
						MemberDAO.getMemberDAO().getMemberNO(LoginController.getLoginController().getloginid()));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
//       System.out.println("................................ : " + CoinNameArray.get(0));
}