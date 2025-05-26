import { createReadStream } from 'node:fs';
import { d as defineEventHandler, s as sendStream } from '../nitro/nitro.mjs';
import 'node:http';
import 'node:https';
import 'node:events';
import 'node:buffer';
import 'node:path';
import 'node:crypto';
import 'node:url';

const index = defineEventHandler((event) => {
  return sendStream(event, createReadStream("./public/index.html"));
});

export { index as default };
//# sourceMappingURL=index.mjs.map
