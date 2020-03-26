local value = redis.call("INCR", KEYS[1])
if (value == 1) then
    redis.call("EXPIRE", KEYS[1], tonumber(ARGV[1]))
end
return value