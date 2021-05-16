package GenericLibrary;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectUtils {

	public void selectTheElement(String input,WebElement ele){//visible text , value ,index
		Select select=new Select(ele);
		List<WebElement> allEle = select.getOptions();
		String basicvalue = "0";
		if(input.equals(basicvalue)) {
			select.selectByIndex(0);
		}
		for(WebElement ele1:allEle) {
			try {
				if(input.equals(ele1.getText())){
					select.selectByVisibleText(input);
					break;
				}if(input.equals(ele1.getAttribute("value"))){
					select.selectByValue(input);
					break;
				}
			} catch (Exception e) {
				int num = Integer.parseInt(input);
				select.selectByIndex(num);
				break;
			}
		}
	}
}

