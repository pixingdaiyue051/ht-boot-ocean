redis.replicate_commands()
local result = redis.call('get', KEYS[1]) == ARGV[1]
if (result) then
    return redis.call('del', KEYS[1])
else
    return 0
end
