redis.replicate_commands()
local result = 0
local scanResultIndex = 0
while scanResultIndex ~= '0' do
    local idx = tonumber(scanResultIndex)
    local scanResult = redis.call('scan', idx, 'match', KEYS[1])
    local scanResultTable = scanResult[2]
    for k, v in pairs(scanResultTable) do
        redis.call('del', v)
    end
    result = result + #scanResultTable
    scanResultIndex = scanResult[1]
end
return result
