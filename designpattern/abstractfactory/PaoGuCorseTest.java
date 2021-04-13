package abstractfactory;

/**
 * @MethodName: $
 * @Description: TODO
 * @Param: $
 * @Return: $
 * @Author: zhangliqian
 * @Date: $
 */
public class PaoGuCorseTest {
    public static void main(String[] args) {
        PythonCourseFactory pythonFactory = new PythonCourseFactory();
        pythonFactory.createNote().edit();
        pythonFactory.createVideo().record();

        JavaCourseFactory javaFactory = new JavaCourseFactory();
        javaFactory.createNote().edit();
        javaFactory.createVideo().record();
    }
}
