package com.unscrambler.controllers

import com.unscrambler.models.Language
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class IndexController {

    @RequestMapping("/")
    fun index(model: Model): String {
        val lang = Language.values()
        model.addAttribute("lang", lang)
        return "index"
    }
}
