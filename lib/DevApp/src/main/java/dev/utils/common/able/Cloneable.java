package dev.utils.common.able;

/**
 * detail: 通用 Clone 接口
 * @author Ttt
 * <pre>
 *     所有通用快捷 Clone 接口定义存储类
 *     全部接口只定义一个方法 cloneMethod() 且返回值一致
 *     唯一差异就是参数不同
 * </pre>
 */
public final class Cloneable {

    private Cloneable() {
    }

    // =======
    // = 无参 =
    // =======

    public interface Clone<T> {

        T cloneMethod();
    }

    // =======
    // = 有参 =
    // =======

    public interface CloneByParam<T, Param> {

        T cloneMethod(Param param);
    }

    public interface CloneByParam2<T, Param, Param2> {

        T cloneMethod(
                Param param,
                Param2 param2
        );
    }

    public interface CloneByParam3<T, Param, Param2, Param3> {

        T cloneMethod(
                Param param,
                Param2 param2,
                Param3 param3
        );
    }

    public interface CloneByParamArgs<T, Param> {

        T cloneMethod(Param... args);
    }
}