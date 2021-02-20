package clientconsumer.clientconsumer.util;

/**
 * @author zhbr
 * @title: ResultUtil
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2020/11/109:35
 */
public class ResultUtil {

    public static Result success(){
        Result result = new Result();
        result.setMessage(Code.SUCCESS.message);
        result.setStatus(Code.SUCCESS.status);
        return result;
    }
    public static Result success(Object data){
        Result result = success();
        result.setData(data);
        return result;
    }
    /***
    	 * description
    	 * @author yangfeng
    	 * @date 2020/11/10
    	 * @param code  默认的错误信息
         *  errorMessage  有指定错误信息时，以此为准
    	 * @return clientconsumer.clientconsumer.util.Result
    	 *
    	 */
    public static Result fail(Code code,String errorMessage){
        Result result = new Result();
        result.setStatus(code.status);
        if(!"".equals(errorMessage)){
            result.setMessage(errorMessage);
        }else {
            result.setMessage(code.message);
        }
        return result;
    }


}
