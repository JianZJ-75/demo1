// 简单的展示信息
function simpleMessage(msg) {
    console.log(msg);
}

// 复杂的展示信息
function complexMessage(msg) {
    console.log(new Date() + ": " + msg);
}

// 批量导出
// export {simpleMessage as sm, complexMessage as cm}

// 默认导出
export default {simpleMessage,complexMessage}