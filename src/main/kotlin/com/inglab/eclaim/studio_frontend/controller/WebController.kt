package com.inglab.eclaim.studio_frontend.controller
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@CrossOrigin
@RequestMapping("/inglab")
class WebController {
    @RequestMapping(value = ["/**/{path:[^\\.]*}"])
    fun index(
        @RequestBody(required = false) req: String?,
        @RequestHeader headers: Map<String, String>,
        request: HttpServletRequest,
        response: HttpServletResponse,
    ): Any {
        val url = request.requestURI

        // Route for IDM module
        if(url.contains("/idm/")){
            return if (url.startsWith("/static")) {
                String.format("forward:/%s", url)
            } else "forward:/idm/index.html"
        }

        // Route for Business module
        if(url.contains("/business/")){
            return if (url.startsWith("/static")) {
                String.format("forward:/%s", url)
            } else "forward:/business/index.html"
        }

        // Default
        return if (url.startsWith("/static")) {
            String.format("forward:/%s", url)
        } else "forward:/index.html"
    }
}
