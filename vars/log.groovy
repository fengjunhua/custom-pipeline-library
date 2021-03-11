/*
1.输出青色trace日志。
*/
def trace(messages){
    def log_Messages =  "\033[46m TRACE: ${messages} \033[0m"
    ansiColor('xterm') {
        println(log_Messages)
    }
}

/*
2.输出蓝色debug日志。
*/
def debug(messages){
    def log_Messages =  "\033[44m DEBUG: ${messages} \033[0m"
    ansiColor('xterm') {
        println(log_Messages)
    }
}

/*
3.输出绿色info日志。
*/
def info(messages){
    def log_Messages =  "\033[42m INFO: ${messages} \033[0m"
    ansiColor('xterm') {
        println(log_Messages)
    }
}

/*
4.输出黄色warning日志。
*/
def warning(messages){
    def log_Messages =  "\033[43m WARNING: ${messages} \033[0m"
    ansiColor('xterm') {
        println(log_Messages)
    }

}

/*
5.输出红色error日志。
*/
def error(messages){
    def log_Messages =  "\033[41m ERROR: ${messages} \033[0m"
    ansiColor('xterm') {
        println(log_Messages)
    }
}

/*
6.输出紫色fatal日志。
*/
def fatal(messages){
    def log_Messages =  "\033[45m FATAL: ${messages} \033[0m"
    ansiColor('xterm') {
        println(log_Messages)
    }
}

/*
7.格式化输出指定带颜色的日志:
    TRACE:    cyan     青色
    DEBUG:    blue     蓝色
    WARNING:  yellow   黄色
    INFO:     green    绿色
    ERROR:    red      红色
    FATAL:    magenta  紫色
*/
def log(leval, messages){
    log_Messages = ['trace'     : "\033[46m TRACE: ${messages} \033[0m",
                    'trace1'    : "\033[36m TRACE: ${messages} \033[0m",
                    'trace2'    : "\033[36m TRACE: >>>>>>>>>>>>>>>>${messages}>>>>>>>>>>>>>>>> \033[0m",
                    'trace3'    : "\033[40;36m TRACE: >>>>>>>>>>>>>>>>${messages}>>>>>>>>>>>>>>>> \033[0m",
                    'debug'     : "\033[44m DEBUG: ${messages} \033[0m",
                    'debug1'    : "\033[34m DEBUG: ${messages} \033[0m",
                    'debug2'    : "\033[34m DEBUG: >>>>>>>>>>>>>>>>${messages}>>>>>>>>>>>>>>>> \033[0m",
                    'debug3'    : "\033[40;34m DEBUG: >>>>>>>>>>>>>>>>${messages}>>>>>>>>>>>>>>>> \033[0m",
                    'info'      : "\033[42m INFO: ${messages} \033[0m",
                    'info1'     : "\033[32m INFO: ${messages} \033[0m",
                    'info2'     : "\033[32m INFO: >>>>>>>>>>>>>>>>${messages}>>>>>>>>>>>>>>>> \033[0m",
                    'info3'     : "\033[40;32m INFO: >>>>>>>>>>>>>>>>${messages}>>>>>>>>>>>>>>>> \033[0m",
                    'warning'   : "\033[43m WARNING: ${messages} \033[0m",
                    'warning1'  : "\033[33m WARNING: ${messages} \033[0m",
                    'warning2'  : "\033[33m WARNING: >>>>>>>>>>>>>>>>${messages}>>>>>>>>>>>>>>>> \033[0m",
                    'warning3'  : "\033[40;33m WARNING: >>>>>>>>>>>>>>>>${messages}>>>>>>>>>>>>>>>> \033[0m",
                    'error'     : "\033[41m ERROR: ${messages} \033[0m",
                    'error1'    : "\033[31m ERROR: ${messages} \033[0m",
                    'error2'    : "\033[31m ERROR: >>>>>>>>>>>>>>>>${messages}>>>>>>>>>>>>>>>> \033[0m",
                    'error3'    : "\033[40;31m ERROR: >>>>>>>>>>>>>>>>${messages}>>>>>>>>>>>>>>>> \033[0m",
                    'fatal'     : "\033[45m FATAL: ${messages} \033[0m",
                    'fatal1'    : "\033[35m FATAL: ${messages} \033[0m",
                    'fatal2'    : "\033[35m FATAL: >>>>>>>>>>>>>>>>${messages}>>>>>>>>>>>>>>>> \033[0m",
                    'fatal3'    : "\033[40;35m FATAL: >>>>>>>>>>>>>>>>${messages}>>>>>>>>>>>>>>>> \033[0m"]

    ansiColor('xterm') {
        println(log_Messages[leval])
    }
}

/*
8.格式化输出带颜色字符串,红色: red,绿色: green,黄色: yellow,蓝色: blue,紫色：magenta,青色: cyan
*/
def printMes(color,messages){
    colors = ['red'      : "\033[31m ${messages} \033[0m",
              'red1'     : "\033[41m ${messages} \033[0m",
              'red2'     : "\033[31m >>>>>>>>>>>>>>>>${messages}>>>>>>>>>>>>>>>> \033[0m",
              'red3'     : "\033[40;31m >>>>>>>>>>>>>>>>${messages}>>>>>>>>>>>>>>>> \033[0m",
              'green'    : "\033[32m ${messages} \033[0m",
              'green1'   : "\033[42m ${messages} \033[0m",
              'green2'   : "\033[32m >>>>>>>>>>>>>>>>${messages}>>>>>>>>>>>>>>>> \033[0m",
              'green3'   : "\033[40;32m >>>>>>>>>>>>>>>>${messages}>>>>>>>>>>>>>>>> \033[0m",
              'yellow'   : "\033[33m ${messages} \033[0m",
              'yellow1'  : "\033[43m ${messages} \033[0m",
              'yellow2'  : "\033[33m >>>>>>>>>>>>>>>>${messages}>>>>>>>>>>>>>>>> \033[0m",
              'yellow3'  : "\033[40;33m >>>>>>>>>>>>>>>>${messages}>>>>>>>>>>>>>>>> \033[0m",
              'blue'     : "\033[34m ${messages} \033[0m",
              'blue1'    : "\033[44m ${messages} \033[0m",
              'blue2'    : "\033[34m >>>>>>>>>>>>>>>>${messages}>>>>>>>>>>>>>>>> \033[0m",
              'blue3'    : "\033[40;34m >>>>>>>>>>>>>>>>${messages}>>>>>>>>>>>>>>>> \033[0m",
              'magenta'  : "\033[35m ${messages} \033[0m",
              'magenta1' : "\033[45m ${messages} \033[0m",
              'magenta2' : "\033[35m >>>>>>>>>>>>>>>>${messages}>>>>>>>>>>>>>>>> \033[0m",
              'magenta3' : "\033[40;35m >>>>>>>>>>>>>>>>${messages}>>>>>>>>>>>>>>>> \033[0m",
              'cyan'     : "\033[36m ${messages} \033[0m",
              'cyan1'    : "\033[46m ${messages} \033[0m",
              'cyan2'    : "\033[36m >>>>>>>>>>>>>>>>${messages}>>>>>>>>>>>>>>>> \033[0m",
              'cyan3'    : "\033[40;36m >>>>>>>>>>>>>>>>${messages}>>>>>>>>>>>>>>>> \033[0m"]
    ansiColor('xterm') {
        println(colors[color])
    }
}
