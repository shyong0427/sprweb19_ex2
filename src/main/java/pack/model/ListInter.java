package pack.model;

import java.util.List;

public interface ListInter {
	List<JikwonDto> selectDataAll();
	List<JikwonDto> selectDataBuser(String buser_num);
	BuserDto selectBuser(String buser_num);
}
