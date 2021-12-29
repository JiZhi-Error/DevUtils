package dev.standard.generate;

import java.lang.reflect.Field;
import java.util.HashSet;

import dev.utils.common.StringUtils;

/**
 * detail: 常量类
 * @author Ttt
 */
final class DevFinalIgnore {

    public static HashSet<String> ignoreSet() {
        HashSet<String> hashSet = new HashSet<>();
        Field[]         fields  = DevFinalIgnore.STR.class.getDeclaredFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            String name      = StringUtils.upperFirstLetter(fieldName.toLowerCase());
            hashSet.add(name);
        }
        return hashSet;
    }

    /**
     * detail: String 类型常量
     * @author Ttt
     */
    public static final class STR {

        // =======
        // = 通用 =
        // =======

        public static final String DEFAULT = "default";
        public static final String NONE    = "none";
        public static final String OBJECT  = "object";
        public static final String UNKNOWN = "unknown";

        public static final String BUG      = "bug";
        public static final String CHANNEL  = "channel";
        public static final String CHARSET  = "charset";
        public static final String CMD      = "cmd";
        public static final String CODE     = "code";
        public static final String CORE     = "core";
        public static final String ENGINE   = "engine";
        public static final String FLAG     = "flag";
        public static final String FROM     = "from";
        public static final String GROUP    = "group";
        public static final String HASH     = "hash";
        public static final String LIB      = "lib";
        public static final String LIMIT    = "limit";
        public static final String MATCH    = "match";
        public static final String MODEL    = "model";
        public static final String MODULE   = "module";
        public static final String RESET    = "reset";
        public static final String ROUTER   = "router";
        public static final String STANDARD = "standard";
        public static final String TARGET   = "target";
        public static final String TO       = "to";

        public static final String DECRYPT = "decrypt";
        public static final String ENCRYPT = "encrypt";
        public static final String PREFIX  = "prefix";
        public static final String SUFFIX  = "suffix";

        public static final String BASE = "base";
        public static final String BEAN = "bean";
        public static final String VO   = "vo";

        public static final String HIGH = "high";
        public static final String LOW  = "low";
        public static final String MAX  = "max";
        public static final String MIN  = "min";

        public static final String EVENT    = "event";
        public static final String LINK     = "link";
        public static final String LISTENER = "listener";
        public static final String LOG      = "log";
        public static final String MESSAGE  = "message";
        public static final String REPORT   = "report";
        public static final String TRACK    = "track";

        public static final String DATABASE = "database";
        public static final String DB       = "db";

        public static final String BLANK   = "blank";
        public static final String GLOBAL  = "global";
        public static final String HOME    = "home";
        public static final String MAIN    = "main";
        public static final String SETTING = "setting";

        // =======
        // = 其他 =
        // =======

        public static final String BANK    = "bank";
        public static final String CONTENT = "content";
        public static final String INDENT  = "indent";
        public static final String KIND    = "kind";
        public static final String LEVEL   = "level";
        public static final String MENU    = "menu";
        public static final String MORE    = "more";
        public static final String NUMBER  = "number";
        public static final String OPERATE = "operate";
        public static final String OPTIONS = "options";
        public static final String OTHER   = "other";
        public static final String REMARK  = "remark";
        public static final String SCORE   = "score";
        public static final String SMS     = "sms";
        public static final String TIMING  = "timing";
        public static final String TITLE   = "title";

        // ==========
        // = 信息相关 =
        // ==========

        public static final String ACCOUNT   = "account";
        public static final String ADDRESS   = "address";
        public static final String AREA      = "area";
        public static final String CITY      = "city";
        public static final String EMAIL     = "email";
        public static final String INFO      = "info";
        public static final String LATITUDE  = "latitude";
        public static final String LONGITUDE = "longitude";
        public static final String MOBILE    = "mobile";
        public static final String NAME      = "name";
        public static final String PASSWORD  = "password";
        public static final String PHONE     = "phone";
        public static final String PROVINCE  = "province";
        public static final String REGION    = "region";
        public static final String SPEC      = "spec";
        public static final String USER      = "user";
        public static final String USER_ID   = "user_id";

        public static final String ACCESS   = "access";
        public static final String ID       = "id";
        public static final String IDENTITY = "identity";
        public static final String TOKEN    = "token";
        public static final String UNIQUE   = "unique";
        public static final String UUID     = "uuid";

        // =======
        // = 媒体 =
        // =======

        public static final String AUDIO      = "audio";
        public static final String IMAGE      = "image";
        public static final String IMAGES     = "images";
        public static final String MEDIA      = "media";
        public static final String MEDIA_TYPE = "media_type";
        public static final String VIDEO      = "video";

        public static final String AAC  = "aac";
        public static final String GIF  = "gif";
        public static final String JPG  = "jpg";
        public static final String JSON = "json";
        public static final String MP3  = "mp3";
        public static final String MP4  = "mp4";
        public static final String PNG  = "png";
        public static final String TEXT = "text";
        public static final String TXT  = "txt";
        public static final String WEBP = "webp";
        public static final String XML  = "xml";

        public static final String BEGIN_TIME = "begin_time";
        public static final String DURATION   = "duration";
        public static final String END_TIME   = "end_time";
        public static final String PLAY_TIME  = "play_time";
        public static final String TIME       = "time";
        public static final String TIMESTAMP  = "timestamp";
        public static final String VALID_TIME = "valid_time";

        // ==========
        // = 时间相关 =
        // ==========

        public static final String CALENDAR = "calendar";

        public static final String DAY          = "day";
        public static final String HOUR         = "hour";
        public static final String MILLI_SECOND = "milli_second";
        public static final String MINUTE       = "minute";
        public static final String MONTH        = "month";
        public static final String SECOND       = "second";
        public static final String WEEK         = "week";
        public static final String YEAR         = "year";

        // ===============
        // = 状态、操作相关 =
        // ===============

        public static final String BIND      = "bind";
        public static final String UN_BINDER = "un_binder";

        public static final String AFTER      = "after";
        public static final String ASYNC      = "async";
        public static final String BEFORE     = "before";
        public static final String CLOSE      = "close";
        public static final String CONNECT    = "connect";
        public static final String DELAY      = "delay";
        public static final String DENIED     = "denied";
        public static final String DISCONNECT = "disconnect";
        public static final String DISK       = "disk";
        public static final String DOWNLOAD   = "download";
        public static final String END        = "end";
        public static final String FAIL       = "fail";
        public static final String GRANTED    = "granted";
        public static final String LOAD       = "load";
        public static final String LOADING    = "loading";
        public static final String PAUSE      = "pause";
        public static final String PERIOD     = "period";
        public static final String PLAY       = "play";
        public static final String REFRESH    = "refresh";
        public static final String REQUEST    = "request";
        public static final String RESPONSE   = "response";
        public static final String RESTART    = "restart";
        public static final String RESULT     = "result";
        public static final String SLEEP      = "sleep";
        public static final String START      = "start";
        public static final String STATE      = "state";
        public static final String STOP       = "stop";
        public static final String SUCCESS    = "success";
        public static final String SYNC       = "sync";
        public static final String UNCONNECT  = "unconnect";
        public static final String UPLOAD     = "upload";
        public static final String VALID      = "valid";
        public static final String WAITING    = "waiting";

        // ==========
        // = 平台相关 =
        // ==========

        public static final String ANDROID      = "android";
        public static final String H5           = "h5";
        public static final String IOS          = "ios";
        public static final String MIN_IPROGRAM = "min_iprogram";
        public static final String WEB          = "web";
        public static final String PLATFORM     = "platform";

        // ===============
        // = UI、APP 相关 =
        // ===============

        public static final String LEFT   = "left";
        public static final String TOP    = "top";
        public static final String RIGHT  = "right";
        public static final String BOTTOM = "bottom";

        public static final String ANIMATION  = "animation";
        public static final String BACKGROUND = "background";
        public static final String BOLD       = "bold";
        public static final String CENTER     = "center";
        public static final String CHECK      = "check";
        public static final String CHECKBOX   = "checkbox";
        public static final String COLOR      = "color";
        public static final String HEIGHT     = "height";
        public static final String HORIZONTAL = "horizontal";
        public static final String INFLATER   = "inflater";
        public static final String LAYOUT     = "layout";
        public static final String MEASURE    = "measure";
        public static final String PROGRESS   = "progress";
        public static final String SCALE      = "scale";
        public static final String SCREEN     = "screen";
        public static final String SCROLL     = "scroll";
        public static final String SELECTED   = "selected";
        public static final String VERTICAL   = "vertical";
        public static final String WEIGHT     = "weight";
        public static final String WIDGET     = "widget";
        public static final String X          = "x";
        public static final String Y          = "y";

        public static final String GRADIENT = "gradient";
        public static final String SHAPE    = "shape";
        public static final String SHARE    = "share";
        public static final String SOLID    = "solid";
        public static final String STROKE   = "stroke";

        public static final String DEBUG        = "debug";
        public static final String RELEASE      = "release";
        public static final String UPGRADE      = "upgrade";
        public static final String VERSION      = "version";
        public static final String VERSION_CODE = "version_code";
        public static final String VERSION_NAME = "version_name";

        public static final String ACTION      = "action";
        public static final String ACTIVITY    = "activity";
        public static final String ADAPTER     = "adapter";
        public static final String APPLICATION = "application";
        public static final String BROADCAST   = "broadcast";
        public static final String BUNDLE      = "bundle";
        public static final String CATEGORY    = "category";
        public static final String CURSOR      = "cursor";
        public static final String DIALOG      = "dialog";
        public static final String EXTRA       = "extra";
        public static final String EXTRAS      = "extras";
        public static final String FRAGMENT    = "fragment";
        public static final String HANDLER     = "handler";
        public static final String HOLDER      = "holder";
        public static final String INTENT      = "intent";
        public static final String LAUNCHER    = "launcher";
        public static final String RECEIVE     = "receive";
        public static final String SERVICE     = "service";
        public static final String TOAST       = "toast";
        public static final String VIBRATE     = "vibrate";
        public static final String VIEW        = "view";

        public static final String BINDING    = "binding";
        public static final String LIFECYCLE  = "lifecycle";
        public static final String LIVE_DATA  = "live_data";
        public static final String PERMISSION = "permission";
        public static final String VIEW_MODEL = "view_model";

        public static final String CHILD       = "child";
        public static final String COMPILE     = "compile";
        public static final String DEVICE      = "device";
        public static final String ELEMENT     = "element";
        public static final String ENVIRONMENT = "environment";
        public static final String MEMORY      = "memory";
        public static final String PACKNAME    = "packname";

        public static final String ASSETS    = "assets";
        public static final String ASSIST    = "assist";
        public static final String CAMERA    = "camera";
        public static final String CAPTURE   = "capture";
        public static final String RAW       = "raw";
        public static final String RICH_TEXT = "rich_text";
        public static final String SOURCE    = "source";
        public static final String TRANSFORM = "transform";

        public static final String BODY    = "body";
        public static final String BROWSER = "browser";
        public static final String CACHE   = "cache";
        public static final String CLIENT  = "client";
        public static final String CONFIG  = "config";
        public static final String COOKIE  = "cookie";
        public static final String FOOTER  = "footer";
        public static final String HEADER  = "header";
        public static final String URI     = "uri";
        public static final String URL     = "url";

        // ==========
        // = 数据相关 =
        // ==========

        public static final String FALSE = "false";
        public static final String TRUE  = "true";

        public static final String ARRAY   = "array";
        public static final String BOOLEAN = "boolean";
        public static final String BYTE    = "byte";
        public static final String CHAR    = "char";
        public static final String DATE    = "date";
        public static final String DOUBLE  = "double";
        public static final String FLOAT   = "float";
        public static final String INT     = "int";
        public static final String INTEGER = "integer";
        public static final String LIST    = "list";
        public static final String LONG    = "long";
        public static final String MAP     = "map";
        public static final String STRING  = "string";

        // ========
        // = 关键字 =
        // ========

        public static final String CATCH     = "catch";
        public static final String CRASH     = "crash";
        public static final String ERROR     = "error";
        public static final String EXCEPTION = "exception";
        public static final String EXIT      = "exit";
        public static final String THROWABLE = "throwable";
        public static final String TRY       = "try";

        public static final String ADD      = "add";
        public static final String APPEND   = "append";
        public static final String ARGS     = "args";
        public static final String COUNT    = "count";
        public static final String CURRENT  = "current";
        public static final String CYCLE    = "cycle";
        public static final String FIND     = "find";
        public static final String GET      = "get";
        public static final String INDEX    = "index";
        public static final String ITEM     = "item";
        public static final String LOOP     = "loop";
        public static final String PAGE     = "page";
        public static final String POSITION = "position";
        public static final String PUT      = "put";
        public static final String QUERY    = "query";
        public static final String REMOVE   = "remove";
        public static final String SET      = "set";
        public static final String SIZE     = "size";
        public static final String SORT     = "sort";
        public static final String SUB      = "sub";
        public static final String TAB      = "tab";
        public static final String TAG      = "tag";
        public static final String TAKE     = "take";
        public static final String UPDATE   = "update";

        public static final String AGENT   = "agent";
        public static final String ALIAS   = "alias";
        public static final String CUSTOM  = "custom";
        public static final String DATA    = "data";
        public static final String FILE    = "file";
        public static final String FOLD    = "fold";
        public static final String IGNORE  = "ignore";
        public static final String INPUT   = "input";
        public static final String KEY     = "key";
        public static final String KEYWORD = "keyword";
        public static final String MISSING = "missing";
        public static final String OUTPUT  = "output";
        public static final String PATH    = "path";
        public static final String PRINT   = "print";
        public static final String READER  = "reader";
        public static final String TASK    = "task";
        public static final String TEMP    = "temp";
        public static final String TYPE    = "type";
        public static final String VALUE   = "value";
        public static final String WRAPPER = "wrapper";
        public static final String WRITER  = "writer";

        public static final String CONTROL  = "control";
        public static final String CONVERT  = "convert";
        public static final String INSTANCE = "instance";
        public static final String PARENT   = "parent";
        public static final String PARSER   = "parser";

        public static final String BUFFER    = "buffer";
        public static final String BUILD     = "build";
        public static final String BUILDER   = "builder";
        public static final String CLASS     = "class";
        public static final String CONST     = "const";
        public static final String ENUM      = "enum";
        public static final String FIELD     = "field";
        public static final String FINAL     = "final";
        public static final String FOR       = "for";
        public static final String FUNCTION  = "function";
        public static final String INTERFACE = "interface";
        public static final String METHOD    = "method";
        public static final String NEW       = "new";
        public static final String NULL      = "null";
        public static final String PARAM     = "param";
        public static final String PARAMS    = "params";
        public static final String PRIVATE   = "private";
        public static final String PROTECTED = "protected";
        public static final String PUBLIC    = "public";
        public static final String RETURN    = "return";
        public static final String STATIC    = "static";
        public static final String VAL       = "val";
        public static final String VAR       = "var";
        public static final String VOID      = "void";
    }
}