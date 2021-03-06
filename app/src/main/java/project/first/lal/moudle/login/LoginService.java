package project.first.lal.moudle.login;

import java.util.HashMap;

import project.first.lal.common.base.ResultMode;
import project.first.lal.moudle.UserInfo;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * user:zhuwt
 *
 * @Description: ${todo}(这里用一句话描述这个类的作用)
 * @ClassName: ${type_name}.java
 * 2017/1/4
 * @说明 代码版权归 作者 所有
 */
public interface LoginService {

    @FormUrlEncoded
    @POST("user/login.action")
    Observable<ResultMode<UserInfo>> login(@FieldMap HashMap<String, String> map);
}
