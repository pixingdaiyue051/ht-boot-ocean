redis.replicate_commands()
local result = redis.call('setnx', KEYS[1], ARGV[1])
if(result == 1) then
    redis.call('pexpire', KEYS[1], ARGV[2])
    result = tonumber(ARGV[1])
else
    result = redis.call('incr', KEYS[1])
end
return result
