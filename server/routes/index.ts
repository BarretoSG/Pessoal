import { createReadStream } from 'node:fs'
import { defineEventHandler, sendStream } from 'h3'

export default defineEventHandler((event) => {
  return sendStream(event, createReadStream('./public/index.html'))
})