import { defineNitroConfig } from "nitropack/config"

//https://nitro.unjs.io/config
export default defineNitroConfig({
  srcDir: "server",
  compatibilityDate: "2025-04-08",
  routeRules: {
    '/': {
      security: {
        csp: {
          'script-src': ["'self'", "'unsafe-inline'", "'unsafe-eval'"]
        }
      }
    }
  }
});