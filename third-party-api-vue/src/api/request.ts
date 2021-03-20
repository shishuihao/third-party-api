import axios from 'axios'

axios.defaults.headers['Content-Type'] = 'application/json;charset=utf-8'
// 创建axios实例
const request = axios.create({
    // axios中请求配置有baseURL选项，表示请求URL公共部分
    //baseURL: "http://localhost:8080",
    baseURL: import.meta.env.BASE_URL,
    // 超时
    timeout: 10000
})

class ErrorResponse {
    timestamp?: string
    status?: number
    error?: string
    message?: string
    path?: string
}

export {request, ErrorResponse}